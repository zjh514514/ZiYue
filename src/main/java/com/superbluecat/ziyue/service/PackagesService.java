package com.superbluecat.ziyue.service;

import java.util.List;

public interface PackagesService {

    Boolean add(String name, Integer money, byte type, Integer monNumber, Integer comNumber, String apiKey);

    Boolean delete(Integer id, String apiKey);

    Boolean update(Integer id, String name, Integer money, Integer monNumber, Integer comNumber, String apiKey);

    List getAll();
}
