PGDMP     .                    w            Marvel    11.3    11.3     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16409    Marvel    DATABASE     �   CREATE DATABASE "Marvel" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
    DROP DATABASE "Marvel";
             postgres    false            �            1259    16412 	   peliculas    TABLE     �   CREATE TABLE public.peliculas (
    "ID" integer NOT NULL,
    "NOMBRE" text NOT NULL,
    "ANIO_EMISION" integer NOT NULL,
    "ANIO_CRONOLOGICO" integer NOT NULL,
    "ESTADO" text NOT NULL
);
    DROP TABLE public.peliculas;
       public         postgres    false            �            1259    16410    peliculas_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."peliculas_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."peliculas_ID_seq";
       public       postgres    false    197                       0    0    peliculas_ID_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."peliculas_ID_seq" OWNED BY public.peliculas."ID";
            public       postgres    false    196            ~
           2604    16415    peliculas ID    DEFAULT     p   ALTER TABLE ONLY public.peliculas ALTER COLUMN "ID" SET DEFAULT nextval('public."peliculas_ID_seq"'::regclass);
 =   ALTER TABLE public.peliculas ALTER COLUMN "ID" DROP DEFAULT;
       public       postgres    false    197    196    197            �
          0    16412 	   peliculas 
   TABLE DATA               a   COPY public.peliculas ("ID", "NOMBRE", "ANIO_EMISION", "ANIO_CRONOLOGICO", "ESTADO") FROM stdin;
    public       postgres    false    197   �
                  0    0    peliculas_ID_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."peliculas_ID_seq"', 22, true);
            public       postgres    false    196            �
           2606    16420    peliculas peliculas_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.peliculas
    ADD CONSTRAINT peliculas_pkey PRIMARY KEY ("ID");
 B   ALTER TABLE ONLY public.peliculas DROP CONSTRAINT peliculas_pkey;
       public         postgres    false    197            �
   �  x�uRAn�0<S��$)˲us� �6A��_6��H�f��9=��XIQ�e��́3���YJ
�|EEX�И���c�
Xxw@{29�����<��P���Z�Ir3ԧdY�O�ߊ�/wQ�ڄ�sn�q�r��h6��F�k;����Y�Or���B���40���-n����`�~�1�����-7������O�~���Y�ƽ���J(댥����o ���.>���	+�� ����4�@�wPs��(��Q��Hn��3����!��җ���W!}�8�k9}� T5X?.�^9p*Oɍ�jO����S�A���.��T6������P�;5��ҋ�.�yzRpFʭ�����[^�V�f{zVxN>hnv@!���Y|�]ȋ��~�i�͏6Ջ� v��](a�����A�Ý�ly������Q�A"�<     