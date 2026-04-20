const BASE_URL = "http://localhost:8080/todo";

const api = {
    async listarTodas() {
        const res = await fetch(`${BASE_URL}/listartodos`);
        ui.render(await res.json());
    },

    async listarHoje() {
        const res = await fetch(`${BASE_URL}/listarhoje`);
        ui.render(await res.json());
    },

    async salvar(tarefa, id = null) {
        const url = id ? `${BASE_URL}/${id}` : `${BASE_URL}/salvartarefa`;
        await fetch(url, {
            method: id ? 'PUT' : 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(tarefa)
        });
        this.listarTodas();
    },

    async excluir(id) {
        if (confirm("Excluir tarefa?")) {
            await fetch(`${BASE_URL}/${id}`, { method: 'DELETE' });
            this.listarTodas();
        }
    },

    async toggleConcluir(id) {
        await fetch(`${BASE_URL}/${id}/concluir`, { method: 'PUT' });
        this.listarTodas();
    }
};