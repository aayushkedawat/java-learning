package com.sochaitea.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }
    void createRun(Run run) {
        runs.add(run);
    }
    void updateRun(Run run) {
        Optional<Run> existingRun = findById(run.id());
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst().stream().findFirst();
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(
                1,
                "first run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                1,
                Location.INDOOR
        ));
        runs.add(new Run(
                1,
                "second run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                2,
                Location.OUTDOOR
        ));
        runs.add(new Run(
                2,
                "third run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                3,
                Location.OUTDOOR
        ));
    }
}
