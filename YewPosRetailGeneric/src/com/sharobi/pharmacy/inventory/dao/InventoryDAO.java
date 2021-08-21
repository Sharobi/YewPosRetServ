package com.sharobi.pharmacy.inventory.dao;

import java.io.InputStream;
import java.util.List;

import com.sharobi.pharmacy.accounts.model.ChartOfAccountDTO;
import com.sharobi.pharmacy.accounts.model.JournalDTO;
import com.sharobi.pharmacy.accounts.model.JournalListDTO;
import com.sharobi.pharmacy.accounts.model.ParaJournalTypeMaster;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.model.GenderMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.ReturnReasonTypeDTO;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.SearchCriteraException;
import com.sharobi.pharmacy.inventory.model.AccountDTO;
import com.sharobi.pharmacy.inventory.model.AccountGroupDTO;
import com.sharobi.pharmacy.inventory.model.AccountMaster;
import com.sharobi.pharmacy.inventory.model.AccountTypeDTO;
import com.sharobi.pharmacy.inventory.model.AreaDTO;
import com.sharobi.pharmacy.inventory.model.BrandDTO;
import com.sharobi.pharmacy.inventory.model.BrandMaster;
import com.sharobi.pharmacy.inventory.model.CategoryMaster;
import com.sharobi.pharmacy.inventory.model.ChargeDTO;
import com.sharobi.pharmacy.inventory.model.ChargeMaster;
import com.sharobi.pharmacy.inventory.model.CityDTO;
import com.sharobi.pharmacy.inventory.model.ContentMaster;
import com.sharobi.pharmacy.inventory.model.ControlAccessItemWiseDTO;
import com.sharobi.pharmacy.inventory.model.CountryMaster;
import com.sharobi.pharmacy.inventory.model.CustomerDTO;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.DistributorDTO;
import com.sharobi.pharmacy.inventory.model.DistributorMaster;
import com.sharobi.pharmacy.inventory.model.DoctorMaster;
import com.sharobi.pharmacy.inventory.model.Expiry;
import com.sharobi.pharmacy.inventory.model.ExpiryDTO;
import com.sharobi.pharmacy.inventory.model.ExpiryDetailsDTO;
import com.sharobi.pharmacy.inventory.model.GroupMaster;
import com.sharobi.pharmacy.inventory.model.ItemDTO;
import com.sharobi.pharmacy.inventory.model.ItemHistoryDTO;
import com.sharobi.pharmacy.inventory.model.ItemMaster;
import com.sharobi.pharmacy.inventory.model.ItemSearchByContentDTO;
import com.sharobi.pharmacy.inventory.model.ItemWithSameContentDTO;
import com.sharobi.pharmacy.inventory.model.LocationDTO;
import com.sharobi.pharmacy.inventory.model.ManufacturerMaster;
import com.sharobi.pharmacy.inventory.model.OpeningStock;
import com.sharobi.pharmacy.inventory.model.RackMaster;
import com.sharobi.pharmacy.inventory.model.RetailTypeControlDTO;
import com.sharobi.pharmacy.inventory.model.RetailTypeDTO;
import com.sharobi.pharmacy.inventory.model.SalesmanDTO;
import com.sharobi.pharmacy.inventory.model.SalesmanMaster;
import com.sharobi.pharmacy.inventory.model.ScheduleMaster;
import com.sharobi.pharmacy.inventory.model.SerialStockStatusDTO;
import com.sharobi.pharmacy.inventory.model.StateDTO;
import com.sharobi.pharmacy.inventory.model.StockDetailsAdjustmentDTO;
import com.sharobi.pharmacy.inventory.model.StockTransfer;
import com.sharobi.pharmacy.inventory.model.StockTransferDTO;
import com.sharobi.pharmacy.inventory.model.StockTransferDetails;
import com.sharobi.pharmacy.inventory.model.StockTransferDetailsDTO;
import com.sharobi.pharmacy.inventory.model.SubCategoryMaster;
import com.sharobi.pharmacy.inventory.model.SubcatByCatDTO;
import com.sharobi.pharmacy.inventory.model.TaxDTO;
import com.sharobi.pharmacy.inventory.model.TaxTypeDTO;
import com.sharobi.pharmacy.inventory.model.UnitMaster;
import com.sharobi.pharmacy.inventory.model.VariantDTO;
import com.sharobi.pharmacy.inventory.model.VariantMaster;
import com.sharobi.pharmacy.inventory.model.VariantTypeDTO;
import com.sharobi.pharmacy.inventory.model.ZoneDTO;
import com.sharobi.pharmacy.procurement.model.ItemCurrentStockDTO;
import com.sharobi.pharmacy.procurement.model.TaxMaster;
import com.sharobi.pharmacy.sales.model.MarketerMaster;

/**
 * rajarshi
 */
public interface InventoryDAO {

	public String addBrand(BrandMaster brandMaster) throws DAOException;
	
	public String addDistributor(DistributorMaster distributorMaster) throws DAOException;
	
	public ResponseObj addItem(ItemMaster item) throws DAOException;

	public ResponseObj addSchedule(ScheduleMaster schedule) throws DAOException;

	public ResponseObj addGroup(GroupMaster groupMaster) throws DAOException;

	public String addRack(RackMaster rackMaster) throws DAOException;
	
	public String addDoctor(DoctorMaster doctorMaster) throws DAOException;
	
	public String addCustomer(CustomerMaster customerMaster) throws DAOException;

	public ResponseObj addSubCategory(SubCategoryMaster subCat) throws DAOException;

	public ResponseObj addContent(ContentMaster contentMaster) throws DAOException;

	public String updateBrand(BrandMaster brand) throws DAOException;
	
	public String updateDistributor(DistributorMaster dist) throws DAOException;
	
	public String updateDoctor(DoctorMaster doc) throws DAOException;
	
	public String updateCustomer(CustomerMaster cust) throws DAOException;
	
	public ResponseObj updateItem(ItemMaster itemMaster) throws DAOException;
	
	public List<CommonResultSetMapper> searchItem(CommonResultSetMapper mapper) throws DAOException;
	
	public List<CommonResultSetMapper> searchItemLite(CommonResultSetMapper mapper) throws DAOException;

	public ResponseObj updateSchedule(ScheduleMaster scheduleMaster)
			throws DAOException;

	public ResponseObj updateGroup(GroupMaster groupMaster) throws DAOException;

	public String updateRack(RackMaster rack) throws DAOException;

	public ResponseObj updateContent(ContentMaster contentMaster)
			throws DAOException;

	public String deleteBrand(String id) throws DAOException;
	
	public String deleteDoctor(String id) throws DAOException;
	
	public String deleteCustomer(String id) throws DAOException;
	
	public ResponseObj deleteDistributorByProc(CommonResultSetMapper mapper) throws DAOException;
	
	public ResponseObj deleteCustomer(CommonResultSetMapper mapper) throws DAOException;
	public String deleteItem(CommonResultSetMapper mapper) throws DAOException;
	
	public String deleteExpiry(CommonResultSetMapper mapper) throws DAOException;
	
	public String postExpiry(CommonResultSetMapper mapper) throws DAOException;
	
	public String deleteDistributor(String id) throws DAOException;

	public String deleteSchedule(String id) throws DAOException;

	public String deleteGroup(String id) throws DAOException;

	public String deleteRack(String id) throws DAOException;

	public String deleteContent(String id) throws DAOException;

	public List<BrandMaster> getBrands(String cmpnyId) throws DAOException;
	
	public List<ItemHistoryDTO> getItemHistory(CommonResultSetMapper mapper) throws DAOException;
	
	public ItemDTO getItemByName(CommonResultSetMapper mapper) throws DAOException;
	
	public CityDTO getCityById(CommonResultSetMapper mapper) throws DAOException;
	
	public AreaDTO getAreaById(CommonResultSetMapper mapper) throws DAOException;
	
	public ZoneDTO getZoneById(CommonResultSetMapper mapper) throws DAOException;
	
	public CommonResultSetMapper getItemByBarcode(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ItemWithSameContentDTO> getItemSameContent(CommonResultSetMapper mapper) throws DAOException;
	
	public List<SubcatByCatDTO> getAllSubcatByCat(CommonResultSetMapper mapper) throws DAOException;
	
	public List<DoctorMaster> getDoctors(String cmpnyId) throws DAOException;
	
	public List<DoctorMaster> getDoctorsByName(CommonResultSetMapper mapper) throws DAOException;
	
	public List<GenderMaster> getGenders(CommonResultSetMapper mapper) throws DAOException;
	
	public List<CustomerMaster> getCustomers(String cmpnyId) throws DAOException;
	
	public List<DistributorMaster> getDistributors(String cmpnyId) throws DAOException;
	
	public int checkDuplicateItem(String name, String id) throws DAOException;
	
	public List<ReturnReasonTypeDTO> getReasonByReturnType(CommonResultSetMapper mapper) throws DAOException;
	
	public List<BrandDTO> getBrandsProc(String cmpnyId) throws DAOException;

	public List<ContentMaster> getContents(String cmpnyId) throws DAOException;

	public List<ScheduleMaster> getSchedules(String cmpnyId)
			throws DAOException;

	public List<GroupMaster> getGroups(String cmpnyId) throws DAOException;

	public List<RackMaster> getRacks(String cmpnyId) throws DAOException;

	public BrandMaster getBrand(String id) throws DAOException;
	public List<ItemCurrentStockDTO> getCurrentStockItemBySku(CommonResultSetMapper mapper) throws DAOException;
	public List<CustomerDTO> getCustomersAll(CommonResultSetMapper mapper) throws DAOException;
	
	public List<DistributorDTO> getDistributorsAllWithOutstanding(CommonResultSetMapper mapper) throws DAOException;
	
	public List<DistributorMaster> getDistributorsAll(CommonResultSetMapper mapper) throws DAOException;
	
	public DistributorDTO getDistributorById(CommonResultSetMapper mapper) throws DAOException;
	public CustomerDTO getCustomerById(CommonResultSetMapper mapper) throws DAOException;
	public List<ItemCurrentStockDTO> getCurrentStockItem(CommonResultSetMapper mapper) throws DAOException;
	public List<StockDetailsAdjustmentDTO> getStockDetailsForAdjustment(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ItemCurrentStockDTO> getCurrentStockItemAtSale(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ExpiryDTO> getAllExpiryDetails(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ExpiryDetailsDTO> getExpiryDetailsById(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ItemSearchByContentDTO> getAllItemSearchByContent(CommonResultSetMapper mapper) throws DAOException;
	public List<ItemSearchByContentDTO> getAllItemStockSearchByContent(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ExpiryDetailsDTO> getAllPendingExpiryItems(CommonResultSetMapper mapper) throws DAOException;
	//added on 08.07.2019
	public List<ExpiryDetailsDTO> getAllManualExpiryItemsByItemId(CommonResultSetMapper mapper) throws DAOException;
	public List<ExpiryDetailsDTO> getAllManualExpiryItemsByItemSKU(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ExpiryDetailsDTO> getExpiryForAdjustmentByPurchase(CommonResultSetMapper mapper) throws DAOException;
	
	public List<ExpiryDetailsDTO> getExpiryForAdjustment(CommonResultSetMapper mapper) throws DAOException;
	
	public ExpiryDTO getExpiryHeaderById(CommonResultSetMapper mapper) throws DAOException;
	
	public List<SerialStockStatusDTO> getSerialStockStatus(CommonResultSetMapper mapper) throws DAOException;
	
	public String uploadStockManual(OpeningStock openingStock) throws DAOException;
	
	public List<TaxDTO> getAllTaxByName(CommonResultSetMapper mapper) throws DAOException;
	public List<TaxDTO> getTaxDetailsById(CommonResultSetMapper mapper) throws DAOException;
	
	public List<TaxDTO> getAllTax(CommonResultSetMapper mapper) throws DAOException;
	
	public String uploadStock(InputStream fileInputStream,CommonResultSetMapper mapper) throws DAOException;
	
	public DoctorMaster getDoctor(String id) throws DAOException;
	
	public CustomerMaster getCustomer(String id) throws DAOException;
	
	public ItemMaster getItemDetails(String id) throws DAOException;
	
	public DistributorMaster getDistributor(String id) throws DAOException;

	public ContentMaster getContent(String id) throws DAOException;

	public ScheduleMaster getSchedule(String id) throws DAOException;

	public GroupMaster getGroup(String id) throws DAOException;

	public RackMaster getRack(String id) throws DAOException;

	public UnitMaster getUnit(String id) throws DAOException;

	public ResponseObj addMarketer(MarketerMaster marketerMaster)
			throws DAOException;
	
	public ResponseObj addManufacturer(ManufacturerMaster manufacturerMaster)
			throws DAOException;

	public ResponseObj updateMarketer(MarketerMaster marketerMaster)
			throws DAOException;
	
	public ResponseObj updateManufacturer(ManufacturerMaster manufacturerMaster)
			throws DAOException;

	public String deleteMarketer(String id) throws DAOException;
	
	public String deleteManufacturer(String id) throws DAOException;

	public List<MarketerMaster> getMarketers(String cmpnyId)
			throws DAOException;
	
	public List<ManufacturerMaster> getManufacturers(String cmpnyId)
			throws DAOException;

	public MarketerMaster getMarketer(String id) throws DAOException;
	
	public ManufacturerMaster getManufacturer(String id) throws DAOException;

	public CategoryMaster getCategory(String id) throws DAOException;

	public SubCategoryMaster getSubCategory(String id) throws DAOException;

	public ResponseObj addUnit(UnitMaster unitMaster) throws DAOException;

	public ResponseObj addCategory(CategoryMaster categoryMaster)
			throws DAOException;

	public ResponseObj updateUnit(UnitMaster unitMaster) throws DAOException;

	public String deleteUnit(String id) throws DAOException;

	public List<UnitMaster> getUnits(String cmpnyId) throws DAOException;

	public String updateCategory(CategoryMaster categoryMaster)
			throws DAOException;

	public String deleteCategory(String id) throws DAOException;

	public String deleteSubCategory(String id) throws DAOException;

	public List<CategoryMaster> getCategories(String cmpnyId)
			throws DAOException;

	public List<SubCategoryMaster> getSubCategories(String cmpnyId)
			throws DAOException;

	public String updateSubCategory(SubCategoryMaster categoryMaster)
			throws DAOException;

	public List<BrandMaster> searchBrand(BrandMaster brand)
			throws DAOException,SearchCriteraException;
	
	public List<UnitMaster> searchUnit(UnitMaster brand)
			throws DAOException,SearchCriteraException;
	
	public List<CommonResultSetMapper> searchBrandAutoCom(BrandMaster brand)
			throws DAOException,SearchCriteraException;
	
	public List<CommonResultSetMapper> searchMarketerAutoCom(MarketerMaster marketerMaster)
			throws DAOException,SearchCriteraException;
	
	public List<CommonResultSetMapper> searchManuAutoCom(ManufacturerMaster manu)
			throws DAOException,SearchCriteraException;
	
	public List<CommonResultSetMapper> searchContentAutoCom(ContentMaster cntnt)
			throws DAOException,SearchCriteraException;
	
	public List<ContentMaster> searchContent(ContentMaster content)
			throws DAOException;
	public List<MarketerMaster> searchMarketer(MarketerMaster marketerMaster)
			throws DAOException;
	
	public List<ManufacturerMaster> searchManufacturer(ManufacturerMaster manufacturerMaster)
			throws DAOException;
	
	public String createOrUpdateExpiryInvoice(Expiry expiry)
			throws DAOException;
	public TaxDTO getTaxById(CommonResultSetMapper mapper) throws DAOException;
	public ResponseObj updateDistributorByProc(DistributorMaster distributorMaster)
			throws DAOException;
	public ResponseObj updateCustomerByProc(CustomerMaster customerMaster)
			throws DAOException;
	public ResponseObj insertDistributor(DistributorMaster distributorMaster)
			throws DAOException;
	public ResponseObj insertCustomer(CustomerMaster customerMaster)
			throws DAOException;
	public ResponseObj createTax(TaxMaster taxMaster)
			throws DAOException;
	public ResponseObj deleteTax(CommonResultSetMapper mapper) throws DAOException;
	
	public ResponseObj deleteStockAdj(CommonResultSetMapper mapper)
			throws DAOException;
	
	public ResponseObj updateStockAdj(StockDetailsAdjustmentDTO mapper)
			throws DAOException;
	
	public ResponseObj updateTax(TaxMaster taxMaster)
			throws DAOException;

	public List<TaxTypeDTO> getAllTaxType(CommonResultSetMapper mapper)throws DAOException;

	public List<AccountTypeDTO> getAllAccountType(CommonResultSetMapper mapper)throws DAOException;
	
	public List<VariantTypeDTO> getAllVariantType(CommonResultSetMapper mapper)throws DAOException;
	
	public ControlAccessItemWiseDTO getControlAccessItemWise(CommonResultSetMapper mapper)throws DAOException;
	
	public List<VariantDTO> getAllVariant(CommonResultSetMapper mapper)throws DAOException;
	
	public List<ChargeDTO> getAllCharges(CommonResultSetMapper mapper)throws DAOException;
	
	public List<AccountGroupDTO> getAllAccountGroup(CommonResultSetMapper mapper)throws DAOException;
	
	public AccountGroupDTO getAccountGroupById(CommonResultSetMapper mapper)throws DAOException;
	
	public VariantDTO getVariantById(CommonResultSetMapper mapper)throws DAOException;

	public ResponseObj createAccountGroup(AccountGroupDTO accountGroupDTO)throws DAOException;
	
	public ResponseObj createCity(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj createArea(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj createZone(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj updateCity(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj updateZone(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj updateArea(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj deleteCity(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj deleteZone(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj deleteArea(CommonResultSetMapper commonResultSetMapper)throws DAOException;
	
	public ResponseObj updateAccountGroup(AccountGroupDTO accountGroupDTO)throws DAOException;

	public ResponseObj deleteAccountGroup(CommonResultSetMapper mapper)throws DAOException;
	
	public ResponseObj deleteVariant(CommonResultSetMapper mapper)throws DAOException;

	public List<CountryMaster> getCountryList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<StateDTO> getStateByCountryList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<CityDTO> getCityByStateList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<CityDTO> getCityByNameList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<ZoneDTO> getZoneByCityList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<ZoneDTO> getZoneByNameList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<AreaDTO> getAreaByZoneList(CommonResultSetMapper mapper)throws DAOException;
	
	public List<AreaDTO> getAreaByNameList(CommonResultSetMapper mapper)throws DAOException;

	public ResponseObj createSalesMan(SalesmanMaster salesmanMaster)throws DAOException;
	
	public ResponseObj createAccount(AccountMaster master)throws DAOException;
	
	public ResponseObj createCharge(ChargeMaster master)throws DAOException;
	
	public ResponseObj createVariant(VariantMaster master)throws DAOException;
	
	public ResponseObj updateVariant(VariantMaster master)throws DAOException;

	public ResponseObj updateSalesMan(SalesmanMaster salesmanMaster)throws DAOException;

	public List<SalesmanDTO> getAllSalesman(CommonResultSetMapper mapper)throws DAOException;
	
	public List<AccountDTO> getAllAccounts(CommonResultSetMapper mapper)throws DAOException;

	public SalesmanDTO getSalesmanById(CommonResultSetMapper mapper)throws DAOException;

	public ResponseObj deleteSalesman(CommonResultSetMapper mapper)throws DAOException;
	
	public ResponseObj deleteAccount(CommonResultSetMapper mapper)throws DAOException;
	
	public ResponseObj deleteCharge(CommonResultSetMapper mapper)throws DAOException;
	
	public ResponseObj updateAccount(AccountMaster master)throws DAOException;
	
	public ResponseObj updateCharge(ChargeMaster master)throws DAOException;

	public List<RetailTypeDTO> getAllRetailType(CommonResultSetMapper mapper)throws DAOException;

	public List<RetailTypeControlDTO> getAllRetailTypeMenuControl(CommonResultSetMapper mapper)throws DAOException;

	public List<LocationDTO> getAllLocation(CommonResultSetMapper mapper)throws DAOException;


	//26.03.2018
	
	//15.02.2018
		public List<AccountDTO> getAccountsByName(CommonResultSetMapper mapper) throws DAOException;
		
		ResponseObj getDuplicateAccount(CommonResultSetMapper mapper) throws DAOException;
		
		/*public List<AccountTransTypeDTO> getAccountTransType(CommonResultSetMapper mapper)throws DAOException;
		
		public List<ParaAccountTransTypeMaster> getParaAccountTransTypes() throws DAOException;*/


		public List<AccountDTO> getAccountsAutocomplete(CommonResultSetMapper mapper) throws DAOException;
		//21/02/2018

		//22/02/2018
		public String addJournal(JournalListDTO journallistDTO) throws DAOException;

		public ResponseObj deleteJournal(CommonResultSetMapper mapper) throws DAOException;

		public List<ParaJournalTypeMaster> getJournalTypeByQS(CommonResultSetMapper mapper) throws DAOException;

		public List<JournalDTO> getAllJournalByType(CommonResultSetMapper mapper) throws DAOException;

		public List<JournalListDTO> getJournalById(CommonResultSetMapper mapper) throws DAOException;

		public String updateJournal(JournalListDTO journallistDTO) throws DAOException;

		public List<AccountDTO> getLedgerDetailsByCode(CommonResultSetMapper mapper) throws DAOException;

		public List<AccountDTO> getAccountsAutocompleteByCashBank(CommonResultSetMapper mapper) throws DAOException;

		public List<ChartOfAccountDTO> getChartOfAccount(CommonResultSetMapper mapper) throws DAOException;

		public List<AccountDTO> getAccountsAutocompleteByGroup(CommonResultSetMapper mapper) throws DAOException;

		public List<CustomerDTO> getCustomersAllByName(CommonResultSetMapper mapper) throws DAOException;

		public int opStockTransferforYearEnd(CommonResultSetMapper mapper) throws DAOException;/**/

		public List<ItemSearchByContentDTO> getAllItemStockSearchByManufacturerId(CommonResultSetMapper mapper) throws DAOException;

		public List<CommonResultSetMapper> getItemByItemcode(CommonResultSetMapper mapper) throws DAOException;

		public List<ItemCurrentStockDTO> getAllItemStockSearch(CommonResultSetMapper mapper) throws DAOException;

		public List<CommonResultSetMapper> searchItemByCode(CommonResultSetMapper mapper) throws DAOException;

		public List<CommonResultSetMapper> searchItemLiteByCode(CommonResultSetMapper mapper) throws DAOException;
		
		//start stock transfer
		public String createOrUpdateStockTransfer(StockTransfer stkTransfer) throws DAOException;
		public List<StockTransferDTO> getAllStockTransferDetails(CommonResultSetMapper mapper) throws DAOException;
		public StockTransferDTO getStockTransferHeaderById(CommonResultSetMapper mapper) throws DAOException;
		public List<StockTransferDetailsDTO> getStockTransferDetailsById(CommonResultSetMapper mapper) throws DAOException;
		public String dispatchStockTransfer(CommonResultSetMapper mapper) throws DAOException;
		public String deleteStockTransfer(CommonResultSetMapper mapper) throws DAOException;
		public String createOrUpdateStockTransferReceive(StockTransfer stkTransfer) throws DAOException;
		public List<StockTransferDTO> getAllStockTransferReceiveDetails(CommonResultSetMapper mapper) throws DAOException;
		public String closeStockTransferSend(CommonResultSetMapper mapper) throws DAOException;
		public String closeStockTransferReceive(CommonResultSetMapper mapper) throws DAOException;
		public String reStockTransitQty(StockTransferDetails stkDetails) throws DAOException;
		
		//end stock transfer
		
}
