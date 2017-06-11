package com.github.ibspoof.cassandraclient.controllers;

import com.github.ibspoof.cassandraclient.services.CassandraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CassandraService.class.getSimpleName());

    @Autowired
    private CassandraService cassandraService;

//    @PostConstruct
//    public void init() {
//       this.cassandraService = new CassandraService();
//    }

}
