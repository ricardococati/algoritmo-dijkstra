drop table custonodegrafo if exists;

create table custonodegrafo (
	id_custo_node_grafo integer primary key,
	node_origem varchar(1),
	node_destino varchar(1),
	custo integer
);

insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(1, 'A', 'D', 4);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(2, 'D', 'E', 1);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(3, 'E', 'C', 8);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(4, 'C', 'B', 2);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(5, 'B', 'A', 6);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(6, 'A', 'C', 9);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(7, 'D', 'F', 7);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(8, 'F', 'C', 5);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(8, 'F', 'E', 9);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(10, 'B', 'D', 3);
insert into custonodegrafo(id_custo_node_grafo, node_origem, node_destino, custo)
					values(11, 'F', 'A', 3);
