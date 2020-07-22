package com.fazal.mviarchitecturedaggerhilt.room

import com.fazal.mviarchitecturedaggerhilt.model.Blog
import com.fazal.mviarchitecturedaggerhilt.utils.EntityMapper
import javax.inject.Inject

/**
 * Cache Mapper class is responsible for mapping cache object to the domain object
 */
class CacheMapper @Inject constructor() : EntityMapper<BlogCacheEntity, Blog> {

    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainLayer: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainLayer.id,
            title = domainLayer.title,
            body = domainLayer.body,
            image = domainLayer.image,
            category = domainLayer.category
        )
    }

    /**
     * Map the collection of [BlogCacheEntity] to the collection of [Blog]
     *
     * @param entities The collection of [BlogCacheEntity]
     *
     * @return The collection of [Blog]
     *
     * @see mapFromEntity
     */
    fun mapFromEntityList(entities: List<BlogCacheEntity>) : List<Blog> {
        return entities.map { mapFromEntity(it) }
    }

}