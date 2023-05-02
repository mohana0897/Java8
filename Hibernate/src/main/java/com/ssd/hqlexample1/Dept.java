package com.ssd.hqlexample1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {
	
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public int deptno;
		public String dname;
		public String  loc;
		public Dept(int deptno, String dname, String loc) {
			super();
			this.deptno = deptno;
			this.dname = dname;
			this.loc = loc;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}
		@Override
		public String toString() {
			return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
		}

}

