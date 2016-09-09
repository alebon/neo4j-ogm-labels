package neo4jsample.model

import java.util.UUID

import neo4jsample.converter.UuidConverter
import org.neo4j.ogm.annotation.typeconversion.Convert
import org.neo4j.ogm.annotation.{GraphId, Property}

trait Entity {

  @GraphId
  @Property
  var graphId: java.lang.Long = _

  @Property
  @Convert(classOf[UuidConverter])
  var uuid: UUID = _

  this.uuid = UUID.randomUUID()
}
