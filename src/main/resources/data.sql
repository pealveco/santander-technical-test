INSERT INTO products (product_id, name, type)
VALUES ('123456', 'Cuenta Debito', 'DEBIT')
ON CONFLICT (product_id) DO NOTHING;

INSERT INTO products (product_id, name, type)
VALUES ('654321', 'Tarjeta Credito', 'CREDIT')
ON CONFLICT (product_id) DO NOTHING;
