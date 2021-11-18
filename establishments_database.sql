CREATE DATABASE cant_wait;

CREATE TABLE `establishments` (
  `category` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `cep` int(11) NOT NULL,
  `numero` int(255) NOT NULL,
  `waiting_time` int(11) NOT NULL,
  `password` varchar(25) NOT NULL,
  `login` varchar(100) NOT NULL,
  `id` int(11) NOT NULL,
  `open` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `establishments`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `establishments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

