set M2_REPO="C:/documents and settings/"%1"/.m2/repository"
set DP=%M2_REPO%/postgresql/postgresql/8.3-603.jdbc4/postgresql-8.3-603.jdbc4.jar
set JAR=%2
set PATH=%PATH%;C:\Program Files\Graphviz 2.21\bin
java -jar %JAR% -dp %DP% -t pgsql -host localhost -db finmgrdb -s public -u postgres -p postgres -o outputDir
