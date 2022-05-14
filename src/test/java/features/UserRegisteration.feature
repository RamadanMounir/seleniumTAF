Feature: User Registeration
		i want to check that the user can register in our e-commerce website.
		
		Scenario Outline: User Registeration
			Given The user on the Home Page
				When I click on Register link
				And i entered "<firstname>","<lastname>","<email>","<password>"
				Then the Registeration page displayed successfully
				
		Examples:
				| firstname | lastname  |        email      | password  |
				| ali     	| alaa   		| suuuuuue@Test.com | 123456789 |
				| alaa    	| ali 		  | yessssss@Test.com | 123456789 |