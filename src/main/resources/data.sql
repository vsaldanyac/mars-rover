/**
 * CREATE Script for init of DB
 */

-- Create 1 MARS ROVER

insert into mars_rover (id, locationX, locationY)
values (1, 0, 0);

-- Create some texts

insert into Messages (id, text)
values (1, 'Hello');

insert into Messages (id, text)
values (2, 'How are you?');

insert into Messages (id, text)
values (3, 'Nice to meet you');

insert into Messages (id, text)
values (4, 'We come from the Earth');
