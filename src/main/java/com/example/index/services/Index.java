package com.example.index.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Index {
  private String name;
  private String id;
  private List<String> constituents;
  private Date inceptionDate;
  private double indexLevel;
  
  public Index() {}
  
  public Index(final String name, final String id, final List<String> constituents, final Date inceptionDate, final double indexLevel) {
      this.name = name;
      this.id = id;
      this.constituents = new ArrayList<>(constituents);
      this.inceptionDate = new Date(inceptionDate.getTime());
      this.indexLevel = indexLevel;
  }
  public String getName() {
      return name;
  }
  public String getId() {
      return id;
  }
  public List<String> getConstituents() {
      return constituents;
  }
  public Date getInceptionDate() {
      return inceptionDate;
  }
  
  
  public double getIndexLevel() {
      return indexLevel;
  }
  @Override
  public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
  }
  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      Index other = (Index) obj;
      if (id == null) {
          if (other.id != null)
              return false;
      } else if (!id.equals(other.id))
          return false;
      if (name == null) {
          if (other.name != null)
              return false;
      } else if (!name.equals(other.name))
          return false;
      return true;
  }
  
}
