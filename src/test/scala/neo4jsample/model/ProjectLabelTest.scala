package neo4jsample.model

import neo4jsample.repository.{ProjectRepository, TenantRepository}
import neo4jsample.testkit.{BaseSuite, Neo4jOgmTestSuite}

class ProjectLabelTest extends BaseSuite with Neo4jOgmTestSuite {

  "Project Model" should {

    "save properly with tenant label" in {

      val tenant = new Tenant("testtenant")
      TenantRepository.save(tenant)

      val project = new Project(tenant, "TestProject")
      ProjectRepository.save(project)

      assert(project.hasLabel(tenant.name))

      val foundProject = ProjectRepository.findById(project.uuid)

      assert(foundProject isDefined)
      assert(foundProject.get.hasLabel(tenant.name))

    }

  }

}
