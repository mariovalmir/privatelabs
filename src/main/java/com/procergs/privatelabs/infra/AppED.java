package com.procergs.privatelabs.infra;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AppED<PK> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    private boolean delete = false;

    /**
     * usado pela api rest
     *
     * @hidden
     */
    public abstract PK getId();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getId() == null ? 0 : getId().hashCode());
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AppED other = (AppED) obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}