package com.wildcodeschool.JpaHibernateApp.controller;

import com.wildcodeschool.JpaHibernateApp.entity.Effect;
import com.wildcodeschool.JpaHibernateApp.entity.Potion;
import com.wildcodeschool.JpaHibernateApp.repository.EffectRepository;
import com.wildcodeschool.JpaHibernateApp.repository.PotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EffectController {

    @Autowired
    private EffectRepository effectRepository;

    @Autowired
    private PotionRepository potionRepository;

    @GetMapping("/effect/create")
    @ResponseBody
    public void createEffect() {
        Effect shrink = new Effect("You shrink to half your size for 24 hours");
        effectRepository.save(shrink);

        Effect green = new Effect("Your skin turns green");
        effectRepository.save(green);

        Effect invisibility = new Effect("You become invisible for 24 hours");
        effectRepository.save(invisibility);

        Effect levitation = new Effect("You can levitate for 24 hours");
        effectRepository.save(levitation);
    }

    @GetMapping("/effect/add-potion")
    @ResponseBody
    public void addPotion() {
        Potion potion = potionRepository.findById(1L).get();
        Effect shrink = effectRepository.findById(1L).get();
        Effect green = effectRepository.findById(2L).get();
        Effect levitation = effectRepository.findById(4L).get();
        potion.getEffects().add(shrink);
        potion.getEffects().add(green);
        potion.getEffects().add(levitation);
        potionRepository.save(potion);

        Potion invisibilityPotion = potionRepository.findById(2L).get();
        Effect invisibility = effectRepository.findById(3L).get();
        invisibilityPotion.getEffects().add(invisibility);
        potionRepository.save(invisibilityPotion);
    }

    @GetMapping("/effect/shrink")
    @ResponseBody
    public void shrink() {
        Effect shrink = effectRepository.findById(1L).get();
        for (Potion potion : shrink.getPotions()) {
            System.out.println(potion.getName());
        }
    }
}
