CREATE TABLE stock (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL UNIQUE,
                       cost NUMERIC(19, 2) NOT NULL,
                       quantity NUMERIC(19, 2) NOT NULL DEFAULT 0
);

INSERT INTO stock (cost, name, quantity) VALUES
                                             (12.50, 'Farinha de Trigo', 100),
                                             (5.00, 'Molho de Tomate', 50),
                                             (15.00, 'Queijo Mozzarella', 40),
                                             (8.00, 'Azeitona Preta', 30),
                                             (7.50, 'Manjericão', 20),
                                             (6.00, 'Pimentão Vermelho', 25),
                                             (20.00, 'Presunto Parma', 10),
                                             (10.00, 'Alho', 60),
                                             (18.00, 'Tomate Cereja', 35),
                                             (14.00, 'Camarão', 15);
