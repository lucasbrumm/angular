CREATE TABLE IF NOT EXISTS product (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         price VARCHAR(255),
                         dtype varchar(31) NOT NULL
);

INSERT INTO product (name, price, dtype) VALUES
                                             ('Spaghetti ao Sugo', '25.00', 'PASTA'),
                                             ('Fettuccine Alfredo', '30.00', 'PASTA'),
                                             ('Penne ao Pesto', '28.00', 'PASTA'),
                                             ('Salada Caprese', '22.00', 'PASTA'),
                                             ('Molho de Tomate', '10.00', 'SAUCE'),
                                             ('Molho Alfredo', '12.00', 'SAUCE'),
                                             ('Molho Pesto', '15.00', 'SAUCE'),
                                             ('Spaghetti', '8.00', 'PASTA'),
                                             ('Fettuccine', '9.00', 'PASTA'),
                                             ('Penne', '8.50', 'PASTA'),
                                             ('Queijo Parmesão', '5.00', 'INGREDIENT'),
                                             ('Manjericão', '4.00', 'INGREDIENT'),
                                             ('Azeitona Preta', '6.00', 'INGREDIENT'),
                                             ('Tomate Seco', '7.00', 'INGREDIENT'),
                                             ('Alho', '3.00', 'INGREDIENT');