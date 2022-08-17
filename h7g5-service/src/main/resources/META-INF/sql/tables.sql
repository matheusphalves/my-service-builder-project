create table OHQIWTSFHL_H7G5Entry (
	h7g5EntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	h7g5FolderId LONG,
	description VARCHAR(75) null,
	key_ VARCHAR(75) null,
	name VARCHAR(75) null
);

create table OHQIWTSFHL_H7G5Folder (
	h7g5FolderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null
);