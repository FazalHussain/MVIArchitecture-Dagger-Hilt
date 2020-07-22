package com.fazal.mviarchitecturedaggerhilt.utils

/**
 * EntityMapper Interface is a mapper interface to
 * map entity to domain layer or domain layer to entity
 *
 * Entity -> Entity Model -> BlogNetworkEntity
 * Domain Layer -> Domain Layer -> Blog
 */
interface EntityMapper<Entity, DomainLayer> {

    fun mapFromEntity(entity: Entity) : DomainLayer

    fun mapToEntity(domainLayer: DomainLayer) : Entity
}