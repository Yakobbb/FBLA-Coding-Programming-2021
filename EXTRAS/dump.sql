--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-08 14:07:20

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
-- TOC entry 2991 (class 1262 OID 16394)
-- Name: fbla_quiz; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE fbla_quiz WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';


ALTER DATABASE fbla_quiz OWNER TO postgres;

\connect fbla_quiz

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
-- TOC entry 2985 (class 0 OID 16447)
-- Dependencies: 201
-- Data for Name: questions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (1, 1, 'How many total FBLA events are there this year?', '45', '62', '70', '53', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (2, 1, 'How many FBLA events start with the letter "B" this year?', '2', '3', '4', '5', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (3, 1, 'In the Entrepreneurship event, what can you receive penalty points for?', 'Speaking for more than 5 minutes', 'Not bringing enough materials', 'Improper Speech', 'Not following Dress Code', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (4, 1, 'Which competitive event procedure WAS NOT changed from previous years?', '3-D Animation', 'Publication Design', 'E-Business', 'International Business', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (5, 1, 'Which event was retired this year?', 'Digital Video Production', 'Sales Presentation', 'Social Media Strategies', 'Emerging Busniness Issues', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (6, 2, 'Introduction to Social Media Strategy is an event for 9th & 10th graders only.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (7, 2, 'Public Service Announcement can only be done individually.', NULL, NULL, NULL, 'false', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (8, 2, 'Electronic Career Portfolio can only be done individually.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (9, 2, 'In the Website Design event, you must include social media links on your website.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (10, 2, 'The objective test administered for Supply Chain Management is 1 hour and 30 minutes.', NULL, NULL, NULL, 'false', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (11, 3, 'Match the unique rubric panel to its corresponding event!', 'Color, backgrounds, font, and sounds are appropriate for the concept/topic', 'Quality of editing and transitions', 'Illustrates participation in the leadership experiences in FBLA', '3-D Animation', 'Digital Video Production', 'Future Business Leader');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (12, 3, 'Match the Penalty Points to the corresponding event!', 'Time Penalty for under 3:31 or over 4:29', 'Over allowed time (7 minutes)', 'Dress code not followed', 'Impromptu Speaking', 'International Business', 'Job Interview');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (13, 3, 'Match the first Objective Test Competency to its corresponding event!', 'Consumer credit', 'Defend and attack (virus, spam, spyware)', 'Managing office procedures', 'Business Calculations', 'Cyber Security', 'Health Care Administration');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (14, 3, 'Match the first Objective Test Competency to its corresponding event!', 'Credit and debt', 'Investment fundamentals', 'Channels of distribution', 'Personal Finance', 'Securities & Investments', 'Supply Chain Management');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (15, 3, 'Match the first Production Test Competency to its corresponding event!', 'Create, search, and query databases', 'Production of all types of busniness forms', 'Basic mathmatical concepts', 'Computer Applications', 'Word Processing', 'Spreadsheet Applications');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (16, 4, 'Publication Design: Create publications for a ________ subscription service (Apple Music, Netflix, Dollar ShaveClub, Hello Fresh, etc.)', NULL, NULL, NULL, 'monthly', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (17, 4, 'Computer Game & Simulation Programming: The game should be a ________ and executable game.', NULL, NULL, NULL, 'standalone', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (18, 4, 'Graphic Design: You have been hired by your chamber of commerce to present a new sports team proposal to the city ________.', NULL, NULL, NULL, 'council', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (19, 4, 'Procedure Changes for 2020-21: If competitors are ________ for a competitive event, there are no guarantees they will get to compete.', NULL, NULL, NULL, 'late', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (20, 4, 'Procedurae Changes for 2020-2021: Five points may be deducted for each ________ of not following guidelines.', NULL, NULL, NULL, 'instance', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (21, 1, 'What does FBLA stand for?', 'For Bright Leaders of America', 'Foreign Business Leaders of America', 'Future Baffled Lingo of Amsterdam', 'Future Business Leaders of America', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (22, 1, 'What article states the purpose of FBLA?', 'Article I', 'Article III', 'Article IV', 'Article III', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (23, 1, 'Which Article and Section state, "Annual dues from 1990 through 1993 shall be $5.00. Annual dues from 1994 until reconsidered shall be $6.00."', 'Article V Section 3', 'Article V Section 4', 'Article II Section 1', 'Article IV Section 2', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (24, 1, 'Which is not an administrative region of FBLA?', 'The Eastern Region', 'The North Central Region', 'The Western Region', 'The South-Eastern Region', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (25, 1, 'Which is not a duty of the elected President?', 'Serve as a member of the board of directors', 'Appoint the parliamentarian', 'Preside over the council meetings and business meetings of FBLA', 'Only serve when in office', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (26, 2, 'The official FBLA emblem and insignia item designs are not protected from infringement.', NULL, NULL, NULL, 'false', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (27, 2, 'The FBLA ByLaws were last amended on July 2, 2016.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (28, 2, 'National FBLA is open for membership to Active Members, Professional Members, Honorary Life Members, and National Honorary Life Members.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (29, 2, 'One of the specific goals of FBLA is to weaken the confidence of students in themselves and their work.', NULL, NULL, NULL, 'false', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (30, 2, 'The treasurer shall present an annual financial report to members at the National Leadership Conference.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (31, 3, 'Match the duty to its corresponding position!', 'Serve as chairman of the national executive council', 'Initiate communication with state officers to promote quality articles for national publications.', 'Advise the president of orderly conduct of business', 'President', 'Secretary', 'Parliamentarian');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (32, 3, 'Match the amount of voting delegates to the amount of members for a local chapter!', 'Under 50 members', '50-100 members', '100+ members', 'Two voting delegates', 'Three voting delegates', 'Four voting delegates');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (33, 3, 'Match the article name to the article number!', 'Membership', 'Dues and Finance', 'Committees', 'Article III', 'Article IV', 'Article X');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (34, 3, 'Match the first sentence of a section to its corresponding article and section number!', 'The fiscal year of the Future Business Leaders of America shall be July 1 through June 30.', 'The administration of FBLA shall be vested in the association president and chief executive officer of FBLA-PBL.', 'National FBLA, as well as the state and local chapters, shall be open for membership to these classes of members:', 'Article IV Section 5', 'Article V Section 3', 'Article III Section 2');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (35, 3, 'Match the article name to the article number!', 'Name', 'Purpose', 'Duties of FBLA National Officers', 'Article I', 'Article II', 'Article VII');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (36, 4, 'Proposed amendments to these bylaws shall be submitted in ________ by local or state chapters or by a national officer...', NULL, NULL, NULL, 'writing', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (37, 4, 'The president of FBLA shall, with the approval of the ________ executive council, establish committees, appoint their members for a period...', NULL, NULL, NULL, 'national', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (38, 4, 'Only those applicants who are present at the ________ Leadership Conference and officially certified by the officer screening committee shall be eligible for nomination.', NULL, NULL, NULL, 'National', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (39, 4, 'The purpose of FBLA is to provide, as an ________ part of the instructional program, additional opportunities for secondary students...', NULL, NULL, NULL, 'integral', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (40, 4, '________ Life Members may be elected to a state or local chapter by a majority vote.', NULL, NULL, NULL, 'Honorary', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (41, 1, 'How large is the 2020-21 Logo Package on the FBLA website?', '59.6 MB', '120.4 MB', '160.7 MB', '78.3 MB', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (42, 1, 'Which is a value that FBLA DOES NOT focus on?', 'Membership Benefits', 'Community Service', 'Leadership Development', 'Monetary Improvement', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (43, 1, 'How many FBLA divisions are there?', '1', '2', '3', '4', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (44, 1, 'Where is FBLA headquartered?', 'Phoenix, Arizona', 'Miami, Florida', 'St. Paul, Minnesota', 'Reston, Virginia', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (45, 1, 'What item IS NOT available in the FBLA store?', 'Bow Tie', 'Mask', 'Jewelry', 'Plaque', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (46, 2, 'FBLA offers their own brand of formal attire.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (47, 2, 'FBLA is sponsored by Country Meats.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (48, 2, 'FBLA is sponsored by GEICO.', NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (49, 2, 'The founder of FBLA is Hamden L. Ford', NULL, NULL, NULL, 'false', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (50, 2, 'FBLA annual memberships surpasses 200,000 for the first time in 1990.', NULL, NULL, NULL, 'false', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (51, 3, 'Match the historical FBLA event to the year it occurred!', 'The postsecondary division, Phi Beta Lambda (PBL), is created.', 'The grand opening of the 11,600 square foot FBLA-PBL National Center is held.', 'FBLA-PBL celebrates 75 years.', '1958', '1991', '2016');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (52, 3, 'Match the person to his/her FBLA position!', 'Gabrielle Gallagher', 'Lauren McMahon', 'Ashlee Woodson', 'Director of Communications & Marketing', 'Digital Marketing Coordinator', 'Sponsors & Partners Coordinator');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (53, 3, 'Match the person to his/her FBLA position!', 'Drew Lojewski', 'Gabrielle Murphy', 'Alan Rzepkowski', 'FBLA National President', 'PBL National President', 'Professional Division National President');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (54, 3, 'Match the division to its participants!', 'FBLA', 'FBLA-ML', 'PBL', 'High Schoolers', 'Middle Schoolers', 'College Students');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (55, 3, 'Match the school to the amount of students participating in FBLA this year!', 'Coral Reef Senior High School', 'Union County Vocational', 'Buchholz High School', '453', '271', '302');
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (56, 4, 'FBLA has three ________, each having competitive events for a different type of student.', NULL, NULL, NULL, 'divisions', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (57, 4, 'The current FBLA ________ is Drew Lojewski.', NULL, NULL, NULL, 'president', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (58, 4, 'The Leadership Community provides the opportunity for FBLA-PBL leaders and advisers to ________, collaborate, and gather online to work together...', NULL, NULL, NULL, 'network', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (59, 4, 'The FBLA store currently offers 8 different types of ________.', NULL, NULL, NULL, 'ties', NULL, NULL);
INSERT INTO public.questions (question_id, question_type, question, pa_1, pa_2, pa_3, answer_1, answer_2, answer_3) VALUES (60, 4, 'The FBLA store offers shirts that mainly come in black, blue, and ________.', NULL, NULL, NULL, 'white', NULL, NULL);


--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 200
-- Name: questions_question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.questions_question_id_seq', 60, true);


-- Completed on 2021-01-08 14:07:21

--
-- PostgreSQL database dump complete
--

