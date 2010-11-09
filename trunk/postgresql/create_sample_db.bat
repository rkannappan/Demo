SET PGPASSWORD=postgres
psql -d template1 -U postgres < ./drop_finmgrdb.sql
psql -d template1 -U postgres < ./create_finmgrdb.sql
psql -d finmgrdb -U postgres < ./finmgrdb.ddl
psql -d finmgrdb -U postgres < ./expense_type.sql
psql -d finmgrdb -U postgres < ./expense.sql
SET PGPASSWORD=