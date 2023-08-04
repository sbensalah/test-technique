package test.technique.soumaya.mappers;

public interface  IMapperEntityDto<E,D> {

	D mapEntityToDto(E e);
	
	void mapDtoToEntity(D d, E e);
	
}
