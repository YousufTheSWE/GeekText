PGDMP  $                    |           geekText    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16615    geekText    DATABASE     �   CREATE DATABASE "geekText" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "geekText";
                postgres    false            �            1259    16943    library    TABLE     �   CREATE TABLE public.library (
    book_id bigint NOT NULL,
    author_name character varying(255),
    book_name character varying(255),
    genre character varying(255),
    rating double precision
);
    DROP TABLE public.library;
       public         heap    postgres    false            �          0    16943    library 
   TABLE DATA           Q   COPY public.library (book_id, author_name, book_name, genre, rating) FROM stdin;
    public          postgres    false    215   �       P           2606    16949    library library_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (book_id);
 >   ALTER TABLE ONLY public.library DROP CONSTRAINT library_pkey;
       public            postgres    false    215            �   P  x�m��N�@�Ϟ��D*��K��JU��xo��8B��qᰋ�F�,y~���l��?,s<	'([�m��4���K���������4\�����Pf���p���k^DkXD�:�p+�J�+�r.a'UKq��XN��������Q*ƥT&^a�%\�*�	�<������rb���;SN�,<V�̻�G���r�R&�Y�2�N:	�Pb���0�^�f$�W���R����p+��0>�;���t�Ε߄�cS�k��L�o��u��+�N��|X��������*���U�7��1<�~5u�Y��:Xek�f���'�     