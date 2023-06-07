package com.capitole.challenge.core.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Data
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "active")
    protected Boolean active;
    protected BaseEntity(){
        //creationDate = OffsetDateTime.now();
        //lastUpdateDate = creationDate;
        active = true;
    }
    public void setActive(Boolean active) {
        this.active = active == null || active.equals(FALSE) ? null : TRUE;
    }

    public Boolean isActive() {
        return active == null ? FALSE : active;
    }
    /*
    @Column(name = "creation_date", nullable = false)
    protected OffsetDateTime creationDate;
    @Column(name = "last_update_date", nullable = false)
    protected OffsetDateTime lastUpdateDate;






    @PreUpdate
    protected void onUpdate(){
        lastUpdateDate = OffsetDateTime.now();
    }

     */
}
