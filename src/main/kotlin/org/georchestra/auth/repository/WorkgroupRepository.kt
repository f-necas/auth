package org.georchestra.auth.repository

import org.georchestra.auth.model.User
import org.georchestra.auth.model.Workgroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface WorkgroupRepository : JpaRepository<Workgroup, Long> {

}

