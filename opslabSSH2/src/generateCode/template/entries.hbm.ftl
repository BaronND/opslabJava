<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <class name="app.entries.${entries}" table="TBL_HBM_GENERALCODE">
        <id name="id" type="java.lang.Integer">
            <column name="ID"/>
            <generator class="native"/>
        </id>
        <property name="codeId" type="java.lang.String">
            <column name="code_Id"/>
        </property>
    </class>
</hibernate-mapping>
