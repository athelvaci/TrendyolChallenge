package com.trendyolConf.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trendyolConf.spring.model.Configuration;
import com.trendyolConf.spring.service.ConfigurationService;


@Controller
public class ConfigurationController {
    private ConfigurationService configurationService;

    @Autowired(required = true)
    @Qualifier(value = "configurationService")
    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    //return list of configurations
    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String listConfigurations(Model model) {
        model.addAttribute("configuration", new Configuration());
        model.addAttribute("listConfigurations", this.configurationService.listConfigurations());
        return "configuration";
    }

    
    //add configuration 
    @RequestMapping(value = "/configuration/add", method = RequestMethod.POST)
    public String addConfiguration(@ModelAttribute("configuration") Configuration p) {

        if (p.getId() == 0) {
            //new configuration, add it
            this.configurationService.addConfiguration(p);
        } else {
            //existing configuration, call update
            this.configurationService.updateConfiguration(p);
        }

        return "redirect:/configurations";

    }

   //remove configuration by id
    @RequestMapping("/remove/{id}")
    public String removeConfiguration(@PathVariable("id") int id) {

        this.configurationService.removeConfiguration(id);
        return "redirect:/configurations";
    }

    //update  configuration by id
    @RequestMapping("/edit/{id}")
    public String editConfiguration(@PathVariable("id") int id, Model model) {
        model.addAttribute("configuration", this.configurationService.getConfigurationById(id));
        model.addAttribute("listConfigurations", this.configurationService.listConfigurations());
        return "configuration";
    }
    
   

}
