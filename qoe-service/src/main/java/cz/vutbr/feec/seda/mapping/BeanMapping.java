package cz.vutbr.feec.seda.mapping;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface BeanMapping {

	public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

	public <T> Set<T> mapToSet(Collection<?> objects, Class<T> mapToClass);

	public <T> T mapTo(Object u, Class<T> mapToClass);

}