package neo4jsample.converter

import java.util.UUID

import org.neo4j.ogm.typeconversion.AttributeConverter

/**
  * Custom UUID converter
  */
class UuidConverter extends AttributeConverter[UUID, String] {

  override def toEntityAttribute(value: String): UUID = {
    if (null == value) {
      return UUID.randomUUID()
    }
    UUID.fromString(value)
  }

  override def toGraphProperty(value: UUID): String = {
    if (null == value) {
      return null
    }
    value.toString
  }
}
