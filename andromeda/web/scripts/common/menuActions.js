function changeMenuItem(menuItem)
{
	jQuery(".left-menu-item").each(function() {
		jQuery(this).removeClass("active");
	});

	jQuery("#" + menuItem).addClass("active");
}

function changeItem(menuItem)
{
	jQuery(".left-menu-item").each(function() {
		jQuery(this).removeClass("active");
	});

	jQuery(menuItem).addClass("active");
}

function showAnnouncementsPage()
{
	jQuery("#contentDiv").load("html/general/announcements.html");
}

