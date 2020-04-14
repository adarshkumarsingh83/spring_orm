package com.adarsh.spring.repository;

import java.util.List;

import com.adarsh.spring.entity.Car;
import org.springframework.dao.DataAccessException;



public interface CarDao {

    public List<Car> getCars() throws DataAccessException;

    public Car getCar(Long carId) throws DataAccessException;

}