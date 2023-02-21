package com.wildcodeschool.JpaHibernateApp.controller;

import com.wildcodeschool.JpaHibernateApp.entity.Category;
import com.wildcodeschool.JpaHibernateApp.entity.Potion;
import com.wildcodeschool.JpaHibernateApp.repository.CategoryRepository;
import com.wildcodeschool.JpaHibernateApp.repository.PotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PotionRepository potionRepository;

    @GetMapping("/category/create")
    @ResponseBody
    public void createCategory() {
        Category restoration = new Category("Restoration");
        categoryRepository.save(restoration);

        Category invisibility = new Category("Invisibility");
        categoryRepository.save(invisibility);

        Category elixir = new Category("Elixir");
        categoryRepository.save(elixir);
    }

    @GetMapping("/category/add-potion")
    @ResponseBody
    public void createPotion() {
        Category restoration = categoryRepository.findById(1L).get();
        Potion demonicLeech = new Potion("A Philter of Demonic Leech", 5, restoration);
        potionRepository.save(demonicLeech);

        Category invisibility = categoryRepository.findById(2L).get();
        Potion invisibilityPotion = new Potion("Invisibility Potion", 10, invisibility);
        potionRepository.save(invisibilityPotion);

        Category elixir = categoryRepository.findById(3L).get();
        Potion elixirOfLife = new Potion("Elixir of Life", 15, elixir);
        potionRepository.save(elixirOfLife);

        Potion elixirOfDeath = new Potion("Elixir of Death", 15, elixir);
        potionRepository.save(elixirOfDeath);

        for (Potion potion : restoration.getPotions()) {
            System.out.println(potion.getName());
        }

        for (Potion potion : invisibility.getPotions()) {
            System.out.println(potion.getName());
        }

        for (Potion potion : elixir.getPotions()) {
            System.out.println(potion.getName());
        }
    }

}
