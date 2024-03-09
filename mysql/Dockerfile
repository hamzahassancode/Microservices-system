FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=grades_db
ADD ./scripts/create_tables.sql /docker-entrypoint-initdb.d
