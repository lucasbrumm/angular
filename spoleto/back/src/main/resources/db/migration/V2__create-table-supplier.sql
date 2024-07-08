CREATE TABLE IF NOT EXISTS supplier (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          address TEXT NOT NULL,
                          contact_number VARCHAR(20) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          cnpj VARCHAR(18) NOT NULL UNIQUE,
                          description TEXT,
                          status VARCHAR(255) NOT NULL
);

INSERT INTO supplier (name, address, contact_number, email, cnpj, description, status) VALUES
                        ('Moinhos do Brasil', 'Rua dos Trigos, 123, São Paulo, SP', '(11) 1234-5678', 'farinhatrigo@example.com', '12.345.678/0001-99', 'Fornecedor de Farinha de Trigo', 'ENABLED'),
                        ('Molhos do Rio', 'Avenida dos Molhos, 456, Rio de Janeiro, RJ', '(21) 2345-6789', 'molhosdorio@example.com', '23.456.789/0001-88', 'Fornecedor de Molho de Tomate', 'ENABLED'),
                        ('Queijos Minas', 'Rua dos Queijos, 789, Belo Horizonte, MG', '(31) 3456-7890', 'queijosminas@example.com', '34.567.890/0001-77', 'Fornecedor de Queijo Mozzarella', 'ENABLED'),
                        ('Azeitonas PR', 'Rua das Azeitonas, 101, Curitiba, PR', '(41) 4567-8901', 'azeitonaspr@example.com', '45.678.901/0001-66', 'Fornecedor de Azeitona Preta', 'ENABLED'),
                        ('Ervas Flora', 'Avenida das Ervas, 202, Florianópolis, SC', '(48) 5678-9012', 'ervasflora@example.com', '56.789.012/0001-55', 'Fornecedor de Manjericão', 'ENABLED'),
                        ('Pimentões RS', 'Rua dos Pimentões, 303, Porto Alegre, RS', '(51) 6789-0123', 'pimentoesrs@example.com', '67.890.123/0001-44', 'Fornecedor de Pimentão Vermelho', 'ENABLED'),
                        ('Presuntos BA', 'Avenida dos Presuntos, 404, Salvador, BA', '(71) 7890-1234', 'presuntosba@example.com', '78.901.234/0001-33', 'Fornecedor de Presunto Parma', 'ENABLED'),
                        ('Alhos PE', 'Rua dos Alhos, 505, Recife, PE', '(81) 8901-2345', 'alhospe@example.com', '89.012.345/0001-22', 'Fornecedor de Alho', 'ENABLED'),
                        ('Tomates CE', 'Avenida dos Tomates, 606, Fortaleza, CE', '(85) 9012-3456', 'tomatesce@example.com', '90.123.456/0001-11', 'Fornecedor de Tomate Cereja', 'ENABLED'),
                        ('Camarões AM', 'Rua dos Camarões, 707, Manaus, AM', '(92) 0123-4567', 'camaroesam@example.com', '01.234.567/0001-00', 'Fornecedor de Camarão', 'ENABLED');
