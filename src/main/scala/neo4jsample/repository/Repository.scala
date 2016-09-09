package neo4jsample.repository

import java.util.UUID

import neo4jsample.model.Entity
import org.neo4j.ogm.cypher.Filter
import org.neo4j.ogm.cypher.query.Pagination
import org.neo4j.ogm.session.{Session, SessionFactory}
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

import scala.reflect._

abstract class Repository[Model <: Entity : ClassTag] {

  lazy val ct = classTag[Model]

  lazy val defaultLimit: Integer = 10

  /**
    * Create a fresh session
    *
    * @return
    */
  def getSession(): Session = {
    val sessionFactory = new SessionFactory("neo4jsample.model")
    sessionFactory.openSession()
  }

  /**
    * Find all method proxy for simplification
    *
    * @param depth
    * @return
    */
  def findAll(depth: Int = 1): List[Model] = {
    val rtc = classTag.runtimeClass
    getSession().loadAll(rtc, depth).asScala.toList.asInstanceOf[List[Model]]
  }

  /**
    * Paginated List request
    *
    * @param skip
    * @param limit
    * @return
    */
  def find(skip: Integer = 0, limit: Integer = defaultLimit): List[Model] = {
    val pagination = new Pagination(0, limit)
    pagination.setOffset(skip)
    getSession().loadAll(ct.runtimeClass, pagination).asScala.toList.asInstanceOf[List[Model]]
  }

  /**
    * Load a single entity by given UUID
    *
    * @param uuid
    * @return
    */
  def findById(uuid: UUID): Option[Model] = {
    val filter = new Filter()
    filter.setPropertyName("uuid")
    filter.setPropertyValue(uuid.toString)
    val resultList = getSession().loadAll(ct.runtimeClass, filter).asScala.toList.asInstanceOf[List[Model]]

    resultList.headOption
  }

  /**
    * Return count of all entities of this type
    *
    * @return
    */
  def countAll(): Long = {
    getSession().countEntitiesOfType(ct.runtimeClass)
  }

  /**
    * Save the entity and return it back
    *
    * @param entity
    * @return
    */
  def save(entity: Model): Model = {
    val session = getSession()
    session.save(entity)
    entity
  }

  /**
    * Default delete method
    *
    * @param entity
    */
  def delete(entity: Model): Unit = {
    getSession().delete(entity)
  }

  /**
    * Helper method to clear all entities from DB (use with care in production)
    */
  def deleteAll(): Unit = {
    getSession().deleteAll(ct.runtimeClass)
  }

}