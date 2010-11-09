SET CLASSPATH="%USERPROFILE%\.m2\repository\postgresql\postgresql\8.3-603.jdbc4\postgresql-8.3-603.jdbc4.jar;ibator-1.2.0-644.jar"

java -cp %CLASSPATH% org.apache.ibatis.ibator.api.IbatorRunner -configfile ibatorConfig.xml -overwrite

