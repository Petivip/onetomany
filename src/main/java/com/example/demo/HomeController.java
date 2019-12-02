package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star movie");
        movie.setYear(2017);
        movie.setDescription("About stars .....");

        Set<Movie> movies = new HashSet<>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("Deathstar movie");
        movie.setYear(2018);
        movie.setDescription("About death star.....");
        movies.add(movie);

        director.setMovies(movies);
        directorRepository.save(director);
        model.addAttribute("directors",directorRepository.findAll());
        return "index";

    }

}
