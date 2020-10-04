INSERT INTO MAIN.PROFILE (id, update_date, first_name, last_name, email, membership_date, membership_statu, premium_membership_expiry_date) VALUES
('6a5df20c-d0cd-443b-8679-3feb77448ded', CURRENT_DATE - 1, 'aaa', 'bbb', 'abc@email.com', CURRENT_DATE - 1, 'SUBSCRIBER', CURRENT_DATE + 30),
('26fb12ce-a550-4bb3-9120-a4799e69f318', CURRENT_DATE - 1, 'ccc', 'ddd', 'xyz@email.com', CURRENT_DATE - 1, 'STANDART', CURRENT_DATE - 10),
('c565003d-0803-457a-8dae-21b7c5b7f7b4', CURRENT_DATE - 1, 'eee', 'fff', 'def@email.com', CURRENT_DATE - 1, 'STANDART', null);

INSERT INTO MAIN.DEBIT_CARD (id, update_date, profile_id, name, no, expiry_date, cvc) VALUES
(RANDOM_UUID(), CURRENT_DATE - 1, '6a5df20c-d0cd-443b-8679-3feb77448ded', 'aaa bbb', '4566996718513291', '05/23', '123'),
(RANDOM_UUID(), CURRENT_DATE - 1, '26fb12ce-a550-4bb3-9120-a4799e69f318', 'ccc ddd', '5149964763837265', '08/24', '456'),
(RANDOM_UUID(), CURRENT_DATE - 1, 'c565003d-0803-457a-8dae-21b7c5b7f7b4', 'eee fff', '379232832837803', '12/23', '789');
