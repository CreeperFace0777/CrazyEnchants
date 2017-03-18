*****
##TODO List


1. Add enchants with random chances (Success Rate - A random % chance. If the player wins the odds, the enchant is added to the item. Destroy Rate - If the player doesn't win the odds there is a chance the item could be destroyed) (Can be found in enchants section of README.md)
2. Add Commands (Can be found in commands section of README.md)
3. Be able to buy books in /enchanter for ingame exp
4. Be able to drag a book with an enchant on over and an item, and apply the enchant depending on a success/destroy rate.
5. Be able to trade unwanted enchant books to /tinker for dust which can be applied to other enchant books for higher chances. The rarity of the dust depends on the book given to the tinkerer, I.E - If the player gives the tinkerer a legendary book, they will get legendary dust back. The player then clicks on the dust for the dust to either change to a failed dust (gunpowder, doesn't do anything), or a dust that can increase the success rate of a book for a random amount (the dust and the book you are trying to increase the success rate of must be of the same rarity).
6. CKits are kits that contain custom enchanted gear. The items you gain in the kit are pre selected as well as the enchants you can get on the items, however the level of the enchant is random.
7. Black Scroll is an item that can remove a random custom enchant on an item. You will then get the book to that enchant with a random success and destroy rate.
8. White Scroll is an item that will protect an item from destroying if the players book would normally destroy the item.
9. The player can only add a certain number of enchants to an item. This number is determined by the permission they have.


####More information can be found on the trello card: https://trello.com/c/CLRx6oZF/7-crazyenchants

****

##Code Snippets

* Loop through each enchant on the player, and if the enchant procs (the player wins the odds) then the ability is added. This would make it so that the enchants are stackable. This would be disabled for some items so if the enchant is found, if it's found again on another armor piece, it is skipped (continued).