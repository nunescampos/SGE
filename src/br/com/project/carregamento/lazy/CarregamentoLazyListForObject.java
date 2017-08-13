package br.com.project.carregamento.lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.framework.controller.crud.Controller;
import br.com.project.listener.ContextLoaderListenerCaixakiUtils;
import br.com.project.model.classes.Entidade;
/**
 * Classe que implementa o carregamento pregui�oso (Carregamento por demanda) para os dataTable do primefaces das telas
 * Assim os carregamentos das tabelas quando tiver muitos registros ser�o sempre rapidos e sem lentid�o
 * @author aluysio
 *
 * @param <T>
 */
public class CarregamentoLazyListForObject<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;

	private List<T> list = new ArrayList<T>();
	
	private List<T> datasource;

	private int totalRegistroConsulta = 0;

	private String query = null;

	private Controller controller = (Controller) ContextLoaderListenerCaixakiUtils.getBean(Controller.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		
		try{
			if (query != null && !query.isEmpty())
				list = (List<T>) controller.findListByQueryDinamica(query, first, pageSize);
			
			if (totalRegistroConsulta == 0){
				setRowCount(list.size());
			}
			else {
				setRowCount(totalRegistroConsulta);
			}
			setPageSize(pageSize);
		}catch (Exception e) {}	

		return (List<T>) list;
	}

	public void setTotalRegistroConsulta(int totalRegistroConsulta, String queryDeBuscaDeConsulta) {
		this.query = queryDeBuscaDeConsulta;
		this.totalRegistroConsulta = totalRegistroConsulta;
	}

	public List<T> getList() {
		return list;
	}

	public void remove(T objetoSelecionado) {
		this.list.remove(objetoSelecionado);
	}

	public void clear() {
		this.query = null;
		this.totalRegistroConsulta = 0;
		this.list.clear();
	}

	public void add(T objetoSelecionado) {
		this.list.add(objetoSelecionado);
	}

	public void addAll(List<T> collections) {
		this.list.addAll(collections);
	}
	@Override
	public Object getRowKey(T object) {
		return object;
	};

	
	@Override
    public T getRowData(String rowkey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data
        List<T> objects = (List<T>) getList();
        for(T obj : objects) {
            if(obj.equals(Integer.valueOf(rowkey)))
                return obj;
        }
        return null;
    }
}
