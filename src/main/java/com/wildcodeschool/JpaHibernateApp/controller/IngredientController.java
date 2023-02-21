package com.wildcodeschool.JpaHibernateApp.controller;

import com.wildcodeschool.JpaHibernateApp.entity.Ingredient;
import com.wildcodeschool.JpaHibernateApp.entity.Potion;
import com.wildcodeschool.JpaHibernateApp.entity.PotionIngredient;
import com.wildcodeschool.JpaHibernateApp.repository.IngredientRepository;
import com.wildcodeschool.JpaHibernateApp.repository.PotionIngredientRepository;
import com.wildcodeschool.JpaHibernateApp.repository.PotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private PotionRepository potionRepository;

    @Autowired
    private PotionIngredientRepository potionIngredientRepository;

    @GetMapping("/ingredient/create")
    @ResponseBody
    public void createAndAddIngredient() {
        Potion potion = potionRepository.findById(1L).get();

        Ingredient sphinx = ingredientRepository.save(new Ingredient("Sphinx's Blood"));
        Ingredient kobold = ingredientRepository.save(new Ingredient("Kobold Gland"));

        potionIngredientRepository.save(new PotionIngredient(potion, sphinx, 12));
        potionIngredientRepository.save(new PotionIngredient(potion, kobold, 4));

        for (PotionIngredient potionIngredient : potion.getPotionIngredients()) {
            System.out.println(potionIngredient.getIngredient().getName());
        }
    }
}
