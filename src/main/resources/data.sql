DROP TABLE IF EXISTS STOPS_LINES CASCADE;
DROP TABLE IF EXISTS STOPS_COURSES CASCADE;
DROP TABLE IF EXISTS USERS_ROLES CASCADE;
DROP TABLE IF EXISTS USERS_TRIPS CASCADE;
DROP TABLE IF EXISTS BOOKED CASCADE;
DROP TABLE IF EXISTS TRIPS CASCADE;
DROP TABLE IF EXISTS STOPS CASCADE;
DROP TABLE IF EXISTS ROLES CASCADE;
DROP TABLE IF EXISTS VEHICLES CASCADE;
DROP TABLE IF EXISTS USERS CASCADE;
DROP TABLE IF EXISTS LINES CASCADE;
DROP TABLE IF EXISTS COURSES CASCADE;
DROP TABLE IF EXISTS VERSION_TEST CASCADE;


CREATE TABLE STOPS
(
    STOP_ID   BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    STOP_NAME VARCHAR(255)                        NOT NULL,
    PRIMARY KEY (STOP_ID)
);

CREATE TABLE LINES
(
    LINE_ID   BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    LINE_NAME VARCHAR(10) NOT NULL,
    PRIMARY KEY (LINE_ID)
);

CREATE TABLE STOPS_LINES
(
    STOPS_LINES_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    LINE_ID        BIGINT NOT NULL,
    STOP_ID        BIGINT NOT NULL,
    ORDINAL        INT    NOT NULL,
    PRIMARY KEY (STOPS_LINES_ID),
    CONSTRAINT STOPS_LINES_FK_STOP FOREIGN KEY (STOP_ID) REFERENCES STOPS (STOP_ID),
    CONSTRAINT STOPS_LINES_FK_LINE FOREIGN KEY (LINE_ID) REFERENCES LINES (LINE_ID)
);

CREATE TABLE COURSES
(
    COURSE_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    LINE_ID   BIGINT NOT NULL,
    ORDINAL   INT    NOT NULL,
    PRIMARY KEY (COURSE_ID),
    CONSTRAINT COURSES_FK_LINE FOREIGN KEY (LINE_ID) REFERENCES LINES (LINE_ID)
);

CREATE TABLE STOPS_COURSES
(
    STOPS_COURSES_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    COURSE_ID        BIGINT NOT NULL,
    STOP_ID          BIGINT NOT NULL,
    ESTIMATED        TIME   NOT NULL,
    PRIMARY KEY (STOPS_COURSES_ID),
    CONSTRAINT STOPS_COURSES_FK_STOP FOREIGN KEY (STOP_ID) REFERENCES STOPS (STOP_ID),
    CONSTRAINT STOPS_COURSES_FK_LINE FOREIGN KEY (COURSE_ID) REFERENCES COURSES (COURSE_ID)
);

CREATE TABLE USERS
(
    USER_ID  BIGINT                NOT NULL GENERATED ALWAYS AS IDENTITY,
    PASSWORD VARCHAR(255)          NOT NULL,
    USERNAME VARCHAR(255)          NOT NULL UNIQUE,
    ENABLED  BOOLEAN DEFAULT FALSE NOT NULL,
    PRIMARY KEY (USER_ID)
);

CREATE TABLE ROLES
(
    ROLE_ID   BIGINT       NOT NULL GENERATED ALWAYS AS IDENTITY,
    ROLE_NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ROLE_ID)
);

CREATE TABLE USERS_ROLES
(
    USER_ROLES_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_ID       BIGINT NOT NULL,
    ROLE_ID       BIGINT NOT NULL,
    PRIMARY KEY (USER_ROLES_ID),
    CONSTRAINT USERS_ROLES_FK_USER FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID),
    CONSTRAINT USERS_ROLES_FK_ROLE FOREIGN KEY (ROLE_ID) REFERENCES ROLES (ROLE_ID)
);

CREATE TABLE VEHICLES
(
    VEHICLE_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    CAPACITY   INT    NOT NULL,
    USER_ID    BIGINT NOT NULL,
    PRIMARY KEY (VEHICLE_ID),
    CONSTRAINT VEHICLES_FK_USER FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID)
);

CREATE TABLE TRIPS
(
    TRIP_ID              BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    COURSE_ID            BIGINT      NOT NULL,
    VEHICLE_ID           BIGINT      NOT NULL,
    OCCUPIED             INT         NOT NULL,
    STATUS               varchar(10) NOT NULL,
    ESTIMATED_START_TIME TIMESTAMP   NOT NULL,
    ESTIMATED_END_TIME   TIMESTAMP   NOT NULL,
    PRIMARY KEY (TRIP_ID),
    CONSTRAINT TRIPS_FK_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSES (COURSE_ID),
    CONSTRAINT TRIPS_FK_VEHICLE FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLES (VEHICLE_ID)
);

CREATE TABLE USERS_TRIPS
(
    USER_TRIPS_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    TRIP_ID       BIGINT NOT NULL,
    USER_ID       BIGINT NOT NULL,
    PRIMARY KEY (USER_TRIPS_ID),
    CONSTRAINT USERS_TRIPS_FK_TRIP FOREIGN KEY (TRIP_ID) REFERENCES TRIPS (TRIP_ID),
    CONSTRAINT USERS_TRIPS_FK_USER FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID)
);

CREATE TABLE BOOKED
(
    BOOKED_ID  BIGINT    NOT NULL GENERATED ALWAYS AS IDENTITY,
    USER_ID    BIGINT,
    VEHICLE_ID BIGINT,
    TRIP_ID    BIGINT,
    START_TIME TIMESTAMP NOT NULL,
    END_TIME   TIMESTAMP NOT NULL,
    PRIMARY KEY (BOOKED_ID),
    CONSTRAINT BOOKED_FK_VEHICLE FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLES (VEHICLE_ID),
    CONSTRAINT BOOKED_FK_USER FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID),
    CONSTRAINT BOOKED_FK_TRIP FOREIGN KEY (TRIP_ID) REFERENCES TRIPS (TRIP_ID)
);

CREATE TABLE VERSION_TEST
(
    VER BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    UPDATED       TIMESTAMP NOT NULL
);
--pass:secret
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user1', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user2', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user3', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user4', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user5', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user6', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user7', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user8', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user9', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user10', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user11', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user12', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user13', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user14', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user15', true);
insert into public.users (user_id, password, username, enabled) values (DEFAULT, '$2a$10$lTBRa6LF1UR5yoL7K7bIzOkWdn/BFB4h7hxy97CCcc/sKyHfDMLPS', 'user16', true);


insert into public.roles (role_id, role_name) values (DEFAULT, 'ROLE_ADMIN');
insert into public.roles (role_id, role_name) values (DEFAULT, 'ROLE_USER');
insert into public.roles (role_id, role_name) values (DEFAULT, 'ROLE_DRIVER');

insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 1, 1);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 2, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 3, 3);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 4, 3);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 5, 3);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 6, 3);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 7, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 8, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 9, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 10, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 11, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 12, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 13, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 14, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 15, 2);
insert into public.users_roles (user_roles_id, user_id, role_id) values (DEFAULT, 16, 2);


insert into public.stops (stop_id, stop_name) values (DEFAULT, 'LOTNISKO CHOPINA');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'PORT LOTNICZY MODLIN');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'WARSZAWA CENTRALNA');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'METRO MŁOCINY');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'METRO WILANOWSKA');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'METRO KABATY');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'PKP PIASECZNO');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'WARSZAWA WSCHODNIA');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'WARSZAWA ZACHODNIA');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'PKP OTWOCK');
insert into public.stops (stop_id, stop_name) values (DEFAULT, 'GÓRA KALWARIA CENTRUM');

insert into public.lines (line_id, line_name) values (DEFAULT, 'M1');
insert into public.lines (line_id, line_name) values (DEFAULT, 'L1');
insert into public.lines (line_id, line_name) values (DEFAULT, 'L2');
insert into public.lines (line_id, line_name) values (DEFAULT, 'L3');
insert into public.lines (line_id, line_name) values (DEFAULT, 'L4');
insert into public.lines (line_id, line_name) values (DEFAULT, 'L5');
insert into public.lines (line_id, line_name) values (DEFAULT, 'L6');

insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 1, 4, 1);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 1, 5, 0);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 1, 6, 2);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 2, 1, 0);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 2, 2, 2);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 2, 3, 1);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 3, 3, 1);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 3, 7, 2);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 4, 9, 0);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 4, 3, 1);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 4, 8, 2);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 5, 3, 0);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 5, 10, 1);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 6, 3, 0);
insert into public.stops_lines (stops_lines_id, line_id, stop_id, ordinal) values (DEFAULT, 6, 11, 1);

insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 1, 0);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 1, 1);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 2, 0);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 2, 1);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 2, 2);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 3, 0);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 4, 0);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 5, 0);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 5, 1);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 5, 2);
insert into public.courses (course_id, line_id, ordinal) values (DEFAULT, 6, 0);

insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 1, 5, '08:35:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 1, 4, '09:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 1, 6, '08:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 2, 5, '10:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 2, 4, '10:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 2, 6, '11:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 3, 1, '11:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 3, 3, '11:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 3, 2, '12:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 4, 1, '14:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 4, 3, '14:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 4, 2, '15:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 5, 1, '16:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 5, 3, '16:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 5, 2, '17:30:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 6, 3, '13:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 6, 7, '14:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 7, 9, '10:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 7, 3, '10:20:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 7, 8, '10:50:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 8, 3, '07:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 8, 10, '08:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 9, 3, '09:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 9, 10, '10:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 10, 3, '11:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 10, 10, '12:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 11, 3, '11:00:00');
insert into public.stops_courses (stops_courses_id, course_id, stop_id, estimated) values (DEFAULT, 11, 11, '11:20:00');

insert into public.vehicles (vehicle_id, capacity, user_id) values (DEFAULT, 10, 3);
insert into public.vehicles (vehicle_id, capacity, user_id) values (DEFAULT, 10, 4);
insert into public.vehicles (vehicle_id, capacity, user_id) values (DEFAULT, 8, 5);
insert into public.vehicles (vehicle_id, capacity, user_id) values (DEFAULT, 5, 6);

insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 1, 1, 0, 'ACTIVE', '2022-02-01 08:00:00.000000', '2022-02-01 09:00:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 1, 1, 0, 'ACTIVE', '2022-02-02 08:00:00.000000', '2022-02-02 09:00:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 1, 1, 0, 'ACTIVE', '2022-02-03 08:00:00.000000', '2022-02-03 09:00:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 2, 2, 0, 'ACTIVE', '2022-02-03 10:00:00.000000', '2022-02-03 11:00:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 2, 2, 0, 'ACTIVE', '2022-02-04 10:00:00.000000', '2022-02-04 11:00:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 2, 2, 0, 'ACTIVE', '2022-02-05 10:00:00.000000', '2022-02-05 11:00:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 3, 3, 0, 'ACTIVE', '2022-02-05 11:00:00.000000', '2022-02-05 12:30:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 3, 3, 0, 'ACTIVE', '2022-02-06 11:00:00.000000', '2022-02-06 12:30:00.000000');
insert into public.trips (trip_id, course_id, vehicle_id, occupied, status, estimated_start_time, estimated_end_time) values (DEFAULT, 3, 3, 0, 'ACTIVE', '2022-02-07 11:00:00.000000', '2022-02-07 12:30:00.000000');

insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 4, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 5, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 6, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 7, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 8, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 9, 7);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 4, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 5, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 6, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 7, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 8, 8);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 9);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 9);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 5, 9);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 7, 9);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 9, 9);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 10);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 4, 10);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 6, 10);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 8, 10);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 7, 11);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 8, 11);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 9, 11);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 12);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 12);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 12);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 4, 12);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 5, 12);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 6, 12);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 13);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 13);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 13);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 4, 13);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 5, 13);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 6, 13);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 14);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 14);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 14);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 15);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 15);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 15);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 1, 16);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 2, 16);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 3, 16);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 9, 15);
insert into public.users_trips (user_trips_id, trip_id, user_id) values (DEFAULT, 9, 16);

update trips set occupied = 8 where trip_id = 1;
update trips set occupied = 8 where trip_id = 2;
update trips set occupied = 8 where trip_id = 3;
update trips set occupied = 5 where trip_id = 4;
update trips set occupied = 5 where trip_id = 5;
update trips set occupied = 5 where trip_id = 6;
update trips set occupied = 4 where trip_id = 7;
update trips set occupied = 4 where trip_id = 8;
update trips set occupied = 5 where trip_id = 9;

insert into public.version_test (ver,updated)
values (DEFAULT,current_timestamp);


