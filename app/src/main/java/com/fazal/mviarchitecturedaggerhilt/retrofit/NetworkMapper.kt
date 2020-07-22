package com.fazal.mviarchitecturedaggerhilt.retrofit

import com.fazal.mviarchitecturedaggerhilt.model.Blog
import com.fazal.mviarchitecturedaggerhilt.utils.EntityMapper
import javax.inject.Inject

/**
 * Network Mapper class is responsible for mapping network object to the domain object
 */
class NetworkMapper @Inject constructor() : EntityMapper<BlogNetworkEntity, Blog> {

    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainLayer: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainLayer.id,
            title = domainLayer.title,
            body = domainLayer.body,
            image = domainLayer.image,
            category = domainLayer.category
        )
    }

    /**
     * Map the collection of [BlogNetworkEntity] to the collection of [Blog]
     *
     * @param entities The collection of [BlogNetworkEntity]
     *
     * @return The collection of [Blog]
     *
     * @see mapFromEntity
     */
    fun mapFromEntityList(entities: List<BlogNetworkEntity>) : List<Blog> {
        return entities.map { mapFromEntity(it) }
    }

}