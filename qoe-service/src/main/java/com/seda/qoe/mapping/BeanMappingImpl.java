package com.seda.qoe.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.dozer.Mapper;
import org.modelmapper.ModelMapper;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Named
public class BeanMappingImpl implements BeanMapping {

	private ModelMapper modelMapper;

	@Inject
	public BeanMappingImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
		List<T> mappedCollection = new ArrayList<T>();
		for (Object object : objects) {
			mappedCollection.add(modelMapper.map(object, mapToClass));
		}
		return mappedCollection;
	}

	@Override
	public <T> Set<T> mapToSet(Collection<?> objects, Class<T> mapToClass) {
		Set<T> mappedCollection = new HashSet<T>();
		for (Object object : objects) {
			mappedCollection.add(modelMapper.map(object, mapToClass));
		}
		return mappedCollection;
	}

	@Override
	public <T> T mapTo(Object u, Class<T> mapToClass) {
		return modelMapper.map(u, mapToClass);
	}

	public boolean isCollection(Object obj) {
		return (obj instanceof Collection) || (obj instanceof Map);
	}

}