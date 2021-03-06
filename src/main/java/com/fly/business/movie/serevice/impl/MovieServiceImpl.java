package com.fly.business.movie.serevice.impl;

import com.fly.business.movie.dao.*;
import com.fly.business.movie.serevice.MovieService;
import com.fly.common.dao.TagDao;
import com.fly.common.dao.TagObjectDao;
import com.fly.pojo.*;
import com.fly.pojo.vo.Page;
import com.fly.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieDao md;
    @Autowired
    private TagDao td;
    @Autowired
    private TagObjectDao tod;
    @Autowired
    private GenreDao gd;
    @Autowired
    private MoviePersonDao mpd;
    @Autowired
    private ParticipantDao pd;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private MovieGenreDao mgd;

    @Override
    public Long size() {
        Long count = md.count();
        return count;
    }

    @Override
    public Page<DoubanMovie> findByPage(String type, Integer p, Integer count) {
        Integer start = (p - 1) * count;
        List<DoubanMovie> movies = md.findByPage(type, start, count);
        Page<DoubanMovie> page = new Page<>();
        Long total = md.count();
        page.setTotal(Integer.valueOf(total.toString()));
        page.setPage(p);
        page.setCount(count);
        page.setBody(movies);
        return page;
    }

    @Override
    public List<FlyTag> findTags(String type) {
        List<FlyTag> tags = td.findByTagType(type);
        return tags;
    }

    @Override
    public Page<DoubanMovie> findByGenreId(String genreId, Integer p, Integer count) {
        Integer start = (p - 1) * count;
        List<String> movieIds = mgd.findIdsByGenreIdAndPage(genreId, start, count);
        if (movieIds.size() == 0) {
            return null;
        }

        List<DoubanMovie> movies = md.findAllById(movieIds);
        List<DoubanImage> movieImages = imageDao.findAllByMovieIds(movieIds);

        // handle image
        Map<String, DoubanImage> imageMap = Util.getReferFromList("fk", movieImages);

        // handle person
        List<DoubanMoviePerson> moviePersons = mpd.findAllByMovieIds(movieIds);
        Map<String, List<String>> moviePersonMap = new HashMap<>();
        for (DoubanMoviePerson person : moviePersons) {
            List<String> items = moviePersonMap.get(person.getMovieId());
            if (items == null) {
                items = new ArrayList<>();
            }
            items.add(person.getPersonId());
            moviePersonMap.put(person.getMovieId(), items);
        }

        Set<String> personIds = new HashSet<>();
        moviePersons.forEach( e -> {
            personIds.add(e.getPersonId());
        });

        List<DoubanImage> personImages = imageDao.findAllByMovieIds(movieIds);
        Map<String, DoubanImage> personImageMap = Util.getReferFromList("fk", personImages);

        List<DoubanParticipant> persons = pd.findAllById(personIds);
        Map<String, DoubanParticipant> personMap = Util.getReferFromList("id", persons);

        for (DoubanMovie m : movies) {
            DoubanImage image = imageMap.get(m.getId());
            List<String> needPersonIds = moviePersonMap.get(m.getId());
            List<DoubanParticipant> directors = m.getDirectors();
            List<DoubanParticipant> casts = m.getCasts();
            if (needPersonIds != null) {
                for (String id : needPersonIds) {
                    DoubanParticipant person = personMap.get(id);
                    if (person != null) {
                        DoubanImage personImage = personImageMap.get(id);
                        person.setImage(personImage);
                        if ("cast".equalsIgnoreCase(person.getType())) {
                            casts.add(person);
                        } else if ("director".equalsIgnoreCase(person.getType())) {
                            directors.add(person);
                        }
                    }
                }
            }

            m.setImage(image);
            m.setCasts(casts);
            m.setDirectors(directors);
        }

        Page<DoubanMovie> page = new Page<>();
        page.setPage(p);
        page.setCount(count);
        page.setBody(movies);
        return page;
    }

    @Override
    public List<DoubanGenre> findGenres() {
        List<DoubanGenre> genres = gd.findAll();
        List<Integer> genreIds = new ArrayList<>();
        genres.forEach(e -> { genreIds.add(e.getId()); });

        List<Map<Integer, Object>> countArr = mgd.countByIds(genreIds);
        Map<Integer, Long> countMap = new HashMap<>();
        countArr.forEach((Map<Integer, Object> m) -> {
            Integer id = (Integer) m.get("genre_id");
            Object o = m.get("COUNT(1)");
            Long value = Long.valueOf(o.toString());
            countMap.put(id, value);
        });

        for (DoubanGenre genre : genres) {
            Long aLong = countMap.get(genre.getId());
            if (aLong == null) {
                aLong = 0L;
            }
            genre.setSubjectCount(aLong);
        }
        return genres;
    }

}
