--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-01-10 19:05:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3322 (class 1262 OID 32780)
-- Name: tqi_evolution; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE tqi_evolution WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE tqi_evolution OWNER TO postgres;

\connect tqi_evolution

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 32782)
-- Name: tqi_evolution; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA tqi_evolution;


ALTER SCHEMA tqi_evolution OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 32791)
-- Name: usuario; Type: TABLE; Schema: tqi_evolution; Owner: postgres
--

CREATE TABLE tqi_evolution.usuario (
    id integer NOT NULL,
    nome character varying(100),
    email character varying(100),
    cpf character varying(11),
    rg character varying(20),
    renda double precision,
    senha character varying(100),
    endereco character varying(512)
);


ALTER TABLE tqi_evolution.usuario OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 32790)
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: tqi_evolution; Owner: postgres
--

CREATE SEQUENCE tqi_evolution.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tqi_evolution.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 210
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: tqi_evolution; Owner: postgres
--

ALTER SEQUENCE tqi_evolution.cliente_id_seq OWNED BY tqi_evolution.usuario.id;


--
-- TOC entry 213 (class 1259 OID 32803)
-- Name: emprestimo; Type: TABLE; Schema: tqi_evolution; Owner: postgres
--

CREATE TABLE tqi_evolution.emprestimo (
    id integer NOT NULL,
    valor double precision,
    qtd_parcelas integer,
    id_cliente integer,
    dat_primeira_parcela date
);


ALTER TABLE tqi_evolution.emprestimo OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 32802)
-- Name: emprestimo_id_seq; Type: SEQUENCE; Schema: tqi_evolution; Owner: postgres
--

CREATE SEQUENCE tqi_evolution.emprestimo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tqi_evolution.emprestimo_id_seq OWNER TO postgres;

--
-- TOC entry 3324 (class 0 OID 0)
-- Dependencies: 212
-- Name: emprestimo_id_seq; Type: SEQUENCE OWNED BY; Schema: tqi_evolution; Owner: postgres
--

ALTER SEQUENCE tqi_evolution.emprestimo_id_seq OWNED BY tqi_evolution.emprestimo.id;


--
-- TOC entry 214 (class 1259 OID 32829)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: tqi_evolution; Owner: postgres
--

CREATE SEQUENCE tqi_evolution.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tqi_evolution.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 3172 (class 2604 OID 32806)
-- Name: emprestimo id; Type: DEFAULT; Schema: tqi_evolution; Owner: postgres
--

ALTER TABLE ONLY tqi_evolution.emprestimo ALTER COLUMN id SET DEFAULT nextval('tqi_evolution.emprestimo_id_seq'::regclass);


--
-- TOC entry 3171 (class 2604 OID 32794)
-- Name: usuario id; Type: DEFAULT; Schema: tqi_evolution; Owner: postgres
--

ALTER TABLE ONLY tqi_evolution.usuario ALTER COLUMN id SET DEFAULT nextval('tqi_evolution.cliente_id_seq'::regclass);


--
-- TOC entry 3174 (class 2606 OID 32796)
-- Name: usuario cliente_pkey; Type: CONSTRAINT; Schema: tqi_evolution; Owner: postgres
--

ALTER TABLE ONLY tqi_evolution.usuario
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 3176 (class 2606 OID 32808)
-- Name: emprestimo emprestimo_pkey; Type: CONSTRAINT; Schema: tqi_evolution; Owner: postgres
--

ALTER TABLE ONLY tqi_evolution.emprestimo
    ADD CONSTRAINT emprestimo_pkey PRIMARY KEY (id);


--
-- TOC entry 3177 (class 2606 OID 32809)
-- Name: emprestimo emprestimo_id_cliente_fkey; Type: FK CONSTRAINT; Schema: tqi_evolution; Owner: postgres
--

ALTER TABLE ONLY tqi_evolution.emprestimo
    ADD CONSTRAINT emprestimo_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES tqi_evolution.usuario(id);


-- Completed on 2022-01-10 19:05:30

--
-- PostgreSQL database dump complete
--
