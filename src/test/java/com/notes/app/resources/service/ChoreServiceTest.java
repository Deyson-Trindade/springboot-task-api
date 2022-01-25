package com.notes.app.resources.service;

import com.notes.app.model.Chore;
import com.notes.app.service.chores.ChoresService;
import com.notes.app.service.chores.ChoresServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ChoreServiceTest {

    @Autowired
    //@Qualifier() caso o Bean tenha um nome diferente do definido passar como parâmetro.
    private ChoresService choresService;

    @TestConfiguration
    static class ChoreServiceImplTestContextConfiguration {

        // O @Bean pode receber um nome como parâmetro e vai ser o nome injetado e caso não receba um nome
        // ele recebe o mesmo nome do método
        @Bean
        public ChoresService choresService() {
            return new ChoresServiceImpl();
        }

    }


    @Test
    public void whenCallListAll_thenListCannotBeEmpty() {

        List<Chore> choreList = choresService.listAll();
        Assert.assertFalse(choreList.isEmpty());
    }

    @Test
    public void whenDeleteAChore_thenShowOneLessInTheList() {

        Chore chore = new Chore(true, "Take the trash out");

        int antes = choresService.listAll().size();
        choresService.delete(chore);
        int depois = choresService.listAll().size();

        Assert.assertEquals(depois + 1, antes);


    }

}
