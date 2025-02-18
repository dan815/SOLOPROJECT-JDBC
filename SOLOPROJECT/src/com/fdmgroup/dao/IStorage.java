package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.IStorable;

public interface IStorage<T extends IStorable> {
	public T create(T t);
	public T findById(int id);
	public List<T> findAll();
}
